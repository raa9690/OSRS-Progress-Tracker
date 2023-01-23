import { Component, OnInit } from '@angular/core';
import { SkillDto } from '../skillDto';
import { SkillService } from '../skill.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-skill-list',
  templateUrl: './skill-list.component.html',
  styleUrls: ['./skill-list.component.css']
})
export class SkillListComponent implements OnInit {
  skills$: Observable<SkillDto[]> | undefined;
  result: string = "did I fail?";
  triedToSet: boolean = false;

  constructor(
    private skillService: SkillService
  ) {  }

  ngOnInit() {
    this.getSkills();
  }

  getSkills(): void {
    this.skills$ = this.skillService.getSkills();
  }

  didSetSkill(){
    this.triedToSet = true;
  }

}
