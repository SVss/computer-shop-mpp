import {Component} from "@angular/core";

import {ListComponent} from "../base/list.component";
import {ComponentTypeService} from "../../service/component-type.service";
import {ComponentTypeModel} from "../../model/full/component-type-model";
import {ComponentTypeBriefModel} from "../../model/brief/component-type-brief-model";


@Component({
    selector: 'comp-type-list',
    templateUrl: './comp-type-list.component.html'
})
export class ComponentTypesListComponent extends ListComponent<ComponentTypeModel, ComponentTypeBriefModel> {
    constructor(private componentTypeService: ComponentTypeService) {
        super(componentTypeService);
    }

    protected getEmptyModel(): ComponentTypeModel {
        return ComponentTypeModel.empty();
    }
}
