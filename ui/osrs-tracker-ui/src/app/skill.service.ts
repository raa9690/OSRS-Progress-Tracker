import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of, throwError } from 'rxjs';
import { catchError, map, tap, retry } from 'rxjs/operators';
import { SkillDto } from './skillDto';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient
    ) { }

  getSkills(): Observable<SkillDto[]>{
    return this.http.get<SkillDto[]>('http://localhost:8080/api/skills');
  }

}
