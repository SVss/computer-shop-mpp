import {OnDestroy, OnInit} from "@angular/core";

import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs/Subscription";
import {ACCESS, EDIT, VIEW} from "../../shared/route-consts";
import {HttpOAuthService} from "../../shared/http-oauth.service";

export class BasePage implements OnInit, OnDestroy {
    private router: Router;
    protected route: ActivatedRoute;
    protected error: string;
    protected isReadOnly: boolean;
    private sub: Subscription;
    private routerSub: Subscription;

    constructor(private authService: HttpOAuthService, r: Router, route: ActivatedRoute) {
        this.route = route;
        this.router = r;
    }

    ngOnInit(): void {
        this.routerSub = this.route.url.subscribe(
            u => {
                let current = u[0].toString();
                let routes = this.authService.getUserRoutes()['items'];
                let exists = false;
                let i = 0;
                while (!exists && i < routes.length) {
                    if (routes[i]['path'] == current) {
                        exists = true;
                    }
                    ++i;
                }
                if (exists) {
                    --i;
                    if ((routes[i]['access'] != EDIT) && (u[1].toString() == EDIT)) {
                        this.router.navigate(['404'], {skipLocationChange: true});
                    }
                } else {
                    this.router.navigate(['404'], {skipLocationChange: true});
                }
            }
        );
        this.sub = this.route.params.subscribe(
            x => {
                let type = x[ACCESS];
                switch (type) {
                    case VIEW:
                        this.isReadOnly = true;
                        break;
                    case EDIT:
                        this.isReadOnly = false;
                        break;
                    default:
                        this.router.navigate(['404'], {skipLocationChange: true});
                }
            },
            error => this.error = error
        );
    }

    ngOnDestroy(): void {
        if (this.sub) {
            this.sub.unsubscribe();
        }
        if (this.routerSub) {
            this.routerSub.unsubscribe();
        }
    }

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }
}
