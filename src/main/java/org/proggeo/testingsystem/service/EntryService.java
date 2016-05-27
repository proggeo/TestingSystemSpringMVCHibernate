package org.proggeo.testingsystem.service;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.proggeo.testingsystem.domain.Entry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Proggeo on 5/27/2016.
 */
@Service("entryService")
@Transactional
public class EntryService {
    protected static Logger logger = Logger.getLogger("service");

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Entry> getAll(){
        logger.debug("Retrieveing all entries");

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM Entry");

        return query.list();
    }

    public void add (Entry entry) {
        logger.debug("Adding new entry");
        Session session = sessionFactory.getCurrentSession();
        session.save(entry);
    }

    public List<Entry> getQuestionStats (Integer questionId){
        logger.debug("Calculating stats");
        List<Entry> entries = getAll();
        List<Entry> stats = new ArrayList<Entry>();
        for (Entry entry : entries) {
            if (entry.getQuestionId().equals(questionId)) {
                stats.add(entry);
            }
        }
        return stats;
    }
}
