import {Component, OnInit} from '@angular/core';
import {AuthService} from "./services/auth.service";
import {ActivatedRoute, Router, UrlTree} from "@angular/router";
import {Observable} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'frontend';
  isLoggedInState: Observable<boolean>;

  constructor(private readonly auth: AuthService,
              private readonly router: Router,
              private readonly route: ActivatedRoute) {
    this.isLoggedInState = this.auth.loggedInStateAsObservable;
  }

  ngOnInit(): void {
    this.auth.loggedInStateAsObservable.subscribe(state => {
      let redirectUrl: string | UrlTree = '/level';


      if (state) {
        this.route.queryParams.subscribe(value => {
          if (value["redirectUrl"]) {
            redirectUrl = value["redirectUrl"];
          }
        });
      } else {
        this.route.queryParams.subscribe(value => {
          if (value["redirectUrl"]) {
            redirectUrl = this.router.createUrlTree(
              ['/signin'], {
                queryParams: {
                  redirectUrl: value["redirectUrl"]
                }
              }
            );
          } else {
            redirectUrl = '/signin';
          }
        });
      }

      this.router.navigateByUrl(redirectUrl, {replaceUrl: true})
        .catch(err => {
          console.error(err);
        });
    });
  }

  logout() {
    this.auth.signOut();
  }
}
