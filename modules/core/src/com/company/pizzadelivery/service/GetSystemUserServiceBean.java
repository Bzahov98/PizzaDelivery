package com.company.pizzadelivery.service;

import com.company.pizzadelivery.entity.Employer;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(GetSystemUserService.NAME)
public class GetSystemUserServiceBean implements GetSystemUserService {

	@Inject
	private Persistence persistence;

	@Override
	public Employer getEmployer(com.haulmont.cuba.security.entity.User user) {
		Employer firstResult;
		//TODO query doesnt return entity user so now gets first!!!
		//if(user != null){System.err.println("\n\n\n nema    "+ user.getId() +"\n\n\n");}
		try (Transaction tx = persistence.createTransaction()) {
			TypedQuery<Employer> query = persistence.getEntityManager()
					.createQuery("select u from pizzadelivery_Employer u "/* +
                            "             where u.user = :sysUser"*/, Employer.class);
			//query.setParameter("sysUser", user);
			List<Employer> resultList = query.getResultList();
			//System.err.println("\n\n\n" + resultList.size() + "\n\n\n");
			firstResult = resultList.get(0);
			tx.commit();
		}

		return firstResult;
        /*"select u from petagram_User u" +
                            " where u.user.id = :sysUserID "*/
	}
}