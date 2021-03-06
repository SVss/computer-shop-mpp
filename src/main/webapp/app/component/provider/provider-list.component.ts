import {Component} from "@angular/core";

import {ListComponent} from "../base/list.component";
import {ProviderService} from "../../service/provider.service";
import {ProviderModel} from "../../model/full/provider-model";
import {ProviderBriefModel} from "../../model/brief/provider-brief-model";
import {DocumentService, DocumentType} from "../../shared/document.service";


@Component({
    selector: 'provider-list',
    templateUrl: './provider-list.component.html'
})
export class ProviderListComponent extends ListComponent<ProviderModel, ProviderBriefModel> {
    constructor(service: ProviderService,
                private documentService: DocumentService) {
        super(service);
    }

    protected getEmptyModel(): ProviderModel {
        return ProviderModel.empty();
    }



}
