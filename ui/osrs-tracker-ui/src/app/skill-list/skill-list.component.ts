import { Component, OnInit } from '@angular/core';
import { Skill } from '../skill';
import { SkillService } from '../skill.service';

import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-skill-list',
  templateUrl: './skill-list.component.html',
  styleUrls: ['./skill-list.component.css']
})
export class SkillListComponent implements OnInit {
  skills: Skill[] = [];
  testBool: boolean;

  constructor(
    private route: ActivatedRoute,
    private skillService: SkillService
  ) { 
    this.testBool = false;
  }

  ngOnInit() {
    this.getSkills();
  }

  getSkills(): void {
    this.skillService.getSkills()
    .subscribe(skills => this.skills = skills);
  }


}
