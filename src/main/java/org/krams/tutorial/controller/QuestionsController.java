package org.krams.tutorial.controller;

import com.sun.javafx.sg.prism.NGShape;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Logger;
import org.krams.tutorial.domain.TestQuestion;
import org.krams.tutorial.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Proggeo on 5/26/2016.
 */

@Controller
@RequestMapping("/questions")
public class QuestionsController {
    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name = "questionService")
    private QuestionService questionService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String getQuestions(Model model) {
        logger.debug("Received request to show all questions");

        List<TestQuestion> questions = questionService.getAll();
        model.addAttribute("questions", questions);
        return "questionspage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        logger.debug("Received request to show add page");
        model.addAttribute("questionAttribute", new TestQuestion());
//TODO create addquestion.jsp
        return "addquestion";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("questionAttribute") TestQuestion testQuestion) {
        logger.debug("Received request to add new question");
        questionService.add(testQuestion);
//TODO create addedquestion.jsp
        return "addedquestion";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) Integer id, Model model){
        logger.debug("Received request to delete existing question");
        questionService.delete(id);
        model.addAttribute("id", id);
//tOdO create deletedquestion.jsp
        return "deletedquestion";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id",required = true) Integer id, Model model) {
        logger.debug("Received request to show edit page");

        model.addAttribute("questionAttribute", questionService.get(id));

        //todo create editquestion.jsp
        return "editquestion";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("questionAttribute") TestQuestion testQuestion,
                           @RequestParam(value = "id", required = true) Integer id,
                           Model model) {
        logger.debug("Received request to update question");
        testQuestion.setId(id);

        questionService.edit(testQuestion);
        model.addAttribute("id", id);

        //todo create editedQuestion.jsp
        return "editedquestion";
    }

}
