package org.krams.tutorial.service;

/**
 * Created by Proggeo on 5/26/2016.
 */

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krams.tutorial.domain.TestQuestion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("questionService")
@Transactional
public class QuestionService {
    protected static Logger logger = Logger.getLogger("service");

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public List<TestQuestion> getAll() {
        logger.debug("Retrieveing all test questions");

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM TestQuestion");

        return query.list();
    }

    public TestQuestion get (Integer id){
        Session session = sessionFactory.getCurrentSession();
        TestQuestion testQuestion = (TestQuestion) session.get(TestQuestion.class, id);
        return testQuestion;
    }

    public void add (TestQuestion testQuestion) {
        logger.debug("Adding new quesiton");
        Session session = sessionFactory.getCurrentSession();
        session.save(testQuestion);
    }

    public void delete (Integer id) {
        logger.debug("Deleting existing question");
        Session session = sessionFactory.getCurrentSession();
        TestQuestion testQuestion = (TestQuestion) session.get(TestQuestion.class, id);
        session.delete(testQuestion);
    }

    public void edit (TestQuestion testQuestion) {
        logger.debug("Editing existing question");
        Session session = sessionFactory.getCurrentSession();
        TestQuestion existingTestQuestion = (TestQuestion) session.get(TestQuestion.class,testQuestion.getId());
        existingTestQuestion.setQuestion(testQuestion.getQuestion());
        existingTestQuestion.setAnswer(testQuestion.getAnswer());
        existingTestQuestion.setWrongAnswer1(testQuestion.getWrongAnswer1());
        existingTestQuestion.setWrongAnswer2(testQuestion.getWrongAnswer2());
        existingTestQuestion.setWrongAnswer3(testQuestion.getWrongAnswer3());

        session.save(existingTestQuestion);
    }

}
