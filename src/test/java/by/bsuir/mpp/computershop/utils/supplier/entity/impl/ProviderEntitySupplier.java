package by.bsuir.mpp.computershop.utils.supplier.entity.impl;

import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntityLongSupplier;

public class ProviderEntitySupplier implements EntityLongSupplier<Provider> {

    @Override
    public Provider getValidEntityWithoutId() {
        Provider result = new Provider();
        result.setId(null);
        result.setName(TestHelper.nextString());
        result.setDescription(TestHelper.nextString());
        return result;
    }

    @Override
    public Provider getInvalidEntity() {
        return null;
    }


}
