import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Game } from "../models";
import { firstValueFrom } from 'rxjs';

const URL = "http://localhost:8080/api/game"

@Injectable()
export class GameService {

    constructor(private http: HttpClient) { }

    postGameNameAsForm(name: string): Promise<Game> {
        const form = new HttpParams().set('name',name)
        const headers = new HttpHeaders().set('Content-Type', 'x-www-form-urlencoded')
        return firstValueFrom(
          this.http.post<Game>(URL, form.toString(), {headers: headers})
        )
    }

}