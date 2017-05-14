import {Component, ViewChild} from "@angular/core";

import {ProviderService} from "../../service/provider.service";
import {ProviderListComponent} from "./provider-list.component";
import {ProviderRemovedListComponent} from "./provider-removed-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";


@Component({
    selector: 'provider-page',
    templateUrl: './provider-page.html'
})
export class ProviderPage extends BasePage {
    private service: ProviderService;

    @ViewChild(ProviderListComponent) list: ProviderListComponent;
    @ViewChild(ProviderRemovedListComponent) removedList: ProviderRemovedListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: ProviderService, route: ActivatedRoute) {
        super(authService, r, route);
        this.service = service;
    }

    onDeleteDone() {
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.list.onRefresh();
    }
}
