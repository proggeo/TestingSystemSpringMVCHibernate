package org.krams.tutorial.controller;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.krams.tutorial.domain.Entry;
import org.krams.tutorial.domain.TestQuestion;
import org.krams.tutorial.service.EntryService;
import org.krams.tutorial.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Proggeo on 5/27/2016.
 */
@Controller
@RequestMapping("/test")
public class TestingController {
    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name = "entryService")
    private EntryService entryService;

    @Resource(name = "questionService")
    private QuestionService questionService;

    @RequestMapping(value = "/take", method = RequestMethod.GET)
    public String generateQuestion(Model model) {
        logger.debug("Received request for question");

        ArrayList<TestQuestion> questions = (ArrayList) questionService.getAll();

        Random random = new Random();
        TestQuestion testQuestion = questions.get(random.nextInt(questions.size()));

        List<String> answersList = new ArrayList<String>();
        answersList.add(testQuestion.getAnswer());
        answersList.add(testQuestion.getWrongAnswer1());
        answersList.add(testQuestion.getWrongAnswer2());
        answersList.add(testQuestion.getWrongAnswer3());

        answersList = shuffle(answersList);

        Entry entry = new Entry();
        entry.setQuestionId(testQuestion.getId());

        model.addAttribute("question", testQuestion);
        model.addAttribute("entry", entry);
        model.addAttribute("answers", answersList);
        //todo create taketest.jsp
        return "taketest";
    }

    @RequestMapping(value = "/take", method = RequestMethod.POST)
    public String addEntry(@ModelAttribute("answer") Entry entry, Model model) {

        logger.debug("Received entry on question (" + entry.getQuestionId() + ") with answer: " + entry.getAnswer());
        entryService.add(entry);

        return generateQuestion(model);
    }

    @RequestMapping(value = "/stats",method = RequestMethod.GET)
    public String getStats(@RequestParam(value = "id",required = true) Integer id, Model model){
        logger.debug("Getting stats");

        List<Entry> entries = entryService.getQuestionStats(id);

        TestQuestion testQuestion = questionService.get(id);
        Double totalcount = (double)entries.size();
        String answer1 = testQuestion.getAnswer();
        String answer2 = testQuestion.getWrongAnswer1();
        String answer3 = testQuestion.getWrongAnswer2();
        String answer4 = testQuestion.getWrongAnswer3();
        Double count1 = 0.0;
        Double count2 = 0.0;
        Double count3 = 0.0;
        Double count4 = 0.0;

        for(Entry entry : entries){
            if(entry.getAnswer().equals(answer1)) count1+=1.0;
            else if(entry.getAnswer().equals(answer2)) count2+=1.0;
            else if(entry.getAnswer().equals(answer3)) count3+=1.0;
            else if(entry.getAnswer().equals(answer4)) count4+=1.0;
        }

        count1 = count1*100/totalcount;
        count2 = count2*100/totalcount;
        count3 = count3*100/totalcount;
        count4 = count4*100/totalcount;

        model.addAttribute("question", testQuestion.getQuestion());
        model.addAttribute("answer1", answer1);
        model.addAttribute("answer2", answer2);
        model.addAttribute("answer3", answer3);
        model.addAttribute("answer4", answer4);
        model.addAttribute("count1", count1);
        model.addAttribute("count2", count2);
        model.addAttribute("count3", count3);
        model.addAttribute("count4", count4);
        model.addAttribute("totalcount", totalcount);

        //todo create showstats.jsp
        return "showstats";
    }

    List<String> shuffle(List<String> strings) {
        Random random = new Random();
        for (int i = strings.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String a = strings.get(index);
            strings.set(index, strings.get(i));
            strings.set(i, a);
        }
        return strings;
    }
}
