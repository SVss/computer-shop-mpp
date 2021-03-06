import {Component, ViewChild} from "@angular/core";

import {OrderListComponent} from "./order-list.component";
import {OrderService} from "../../service/order.service";
import {OrderCanceledListComponent} from "./order-canceled-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";

@Component({
    selector: 'order-page',
    templateUrl: './order-page.html'
})
export class OrderPage extends BasePage {
    private service: OrderService;
    protected error: string;

    @ViewChild(OrderListComponent) list: OrderListComponent;
    @ViewChild(OrderCanceledListComponent) removedList: OrderCanceledListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: OrderService, route: ActivatedRoute,
                toasterService: ToasterService) {
        super(authService, r, route, toasterService);
        this.service = service;
    }

    getOperationErrorMessage() {
        return this.COMPONENTS_ERROR_MSG;
    }

    onAddDone() {
        this.popSuccess('Order added');
    }

    onDeleteDone() {
        this.popSuccess('Order deleted');
    }

    onAcceptDone() {
        this.popSuccess('Order accepted');
    }

    onCancelDone() {
        this.popWarning('Order canceled');
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.popSuccess('Order restored');
        this.list.onRefresh();
    }
}
