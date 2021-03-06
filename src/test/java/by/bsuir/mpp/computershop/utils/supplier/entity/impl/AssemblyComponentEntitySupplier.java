package by.bsuir.mpp.computershop.utils.supplier.entity.impl;

import by.bsuir.mpp.computershop.entity.AssemblyComponent;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntityLongSupplier;


public class AssemblyComponentEntitySupplier implements EntityLongSupplier<AssemblyComponent> {

    @Override
    public AssemblyComponent getValidEntityWithoutId() {
        AssemblyComponent result = new AssemblyComponent();
        result.setId(null);
        result.setCount(TestHelper.nextLong());

        return result;
    }

    @Override
    public AssemblyComponent getInvalidEntity() {
        return null;
    }


}
