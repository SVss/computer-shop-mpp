package by.bsuir.mpp.computershop.utils.supplier.entity.impl;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntityLongSupplier;


public class ComponentModelEntitySupplier implements EntityLongSupplier<ComponentModel> {

    @Override
    public ComponentModel getValidEntityWithoutId() {
        ComponentModel result = new ComponentModel();
        result.setId(null);
        result.setName(TestHelper.nextString());
        result.setDescription(TestHelper.nextString());
        return result;
    }

    @Override
    public ComponentModel getInvalidEntity() {
        return null;
    }

}
