package by.bsuir.mpp.computershop.utils.entity.supplier.impl;

import by.bsuir.mpp.computershop.entity.Customer;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntityLongSupplier;

public class CustomerEntitySupplier implements EntityLongSupplier<Customer> {

    @Override
    public Customer getValidEntityWithoutId() {
        Customer result =  new Customer();
        result.setId(null);
        result.setName(TestHelper.nextString());
        result.setDescription(TestHelper.nextString());
        return result;
    }

    @Override
    public Customer getInvalidEntity() {
        return null;
    }

}
