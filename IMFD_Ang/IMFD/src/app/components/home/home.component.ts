import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public slides:any = document.querySelectorAll('.home .slides-container .slide');
  public index:any = 0;
  constructor() { }

  ngOnInit(): void {
    
  }


next(){
    alert("next button hit ")
    alert(this.index)
    this.slides[this.index].classList.remove('active');
    this.index = (this.index + 1) % this.slides.length;
    this.slides[this.index].classList.add('active');
}

prev(){
    this.slides[this.index].classList.remove('active');
    this.index = (this.index - 1 + this.slides.length) % this.slides.length;
    this.slides[this.index].classList.add('active');
}

}
