package by.bsuir.mpp.computershop.utils.supplier.entity.impl;

import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntityLongSupplier;


public class ComponentTypeEntitySupplier implements EntityLongSupplier<ComponentType> {

    @Override
    public ComponentType getValidEntityWithoutId() {
        ComponentType result = new ComponentType();
        result.setId(null);
        result.setName(TestHelper.nextString());
        result.setDescription(TestHelper.nextString());

        return result;
    }

    @Override
    public ComponentType getInvalidEntity() {
        return null;
    }


}
