package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends SoftDeleteRepository<Customer, Long> {

    @Override
    @Transactional
    @Modifying
    @Query(value = "CALL remove_customer(:id);", nativeQuery = true)
    void delete(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "CALL restore_customer(:id);", nativeQuery = true)
    void restore(@Param("id") Long id);
}
