import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Skill } from './skill';

@Injectable({
  providedIn: 'root'
})
export class SkillService {
  private skillsUrl = 'http://localhost8080/api/skills'

  constructor(
    private http: HttpClient
    ) { }

  getSkills(): Observable<Skill[]>{
    return this.http.get<Skill[]>(this.skillsUrl)   
  }

}
