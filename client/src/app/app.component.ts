import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GameService } from './services/game.service';
import { Game } from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'day35workshop';

  form!:FormGroup
  game$!:Promise<Game>
  
  constructor(private fb:FormBuilder, private http:HttpClient, private gameSvc: GameService) {}

  ngOnInit(): void {
    this.form = this.createForm()
  }

  private createForm(): FormGroup {
    return this.fb.group({
      name: this.fb.control('', [ Validators.required ])
    })
  }

  processForm() {
    const name = this.form.value['name']
    this.game$ = this.gameSvc.postGameNameAsForm(name)
  }

}
