package ee.bcs.valiit.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHibernateRepository extends JpaRepository<HibernateAccount, String> {
}
