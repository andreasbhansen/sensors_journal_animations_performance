import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { SecondPage } from '../second/second';


@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  public lottieConfig: Object;
  private anim: any;
  public items = [];

  constructor(public navCtrl: NavController) {
    
    this.lottieConfig = {
      path: 'assets/favourite_app_icon.json',
      loop: false,
      autoplay: false
    };

/*     window["cordova"]["plugins"].cordova_perf_monitor.tinymonitor(null, (success) => {
      console.log(success)
    }, (err) => {
      console.log(err)
    }) */
  }

  handleAnimation(anim: any) {
    this.anim = anim;
  }

  navigateToSecondPage() {
    this.navCtrl.push(SecondPage)
  }

  play() {
    this.anim.stop();
    this.anim.play();
  }

}
