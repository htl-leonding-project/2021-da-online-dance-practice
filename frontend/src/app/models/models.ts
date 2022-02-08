export interface User {
  firstname: string,
  id: number,
  lastname: string,
  password: string,
  role: Role,
  username: string
}

export enum Role {
  STUDENT = 'STUDENT',
  TEACHER = 'TEACHER'
}

export interface Level {
  id: string,
  description: string
}

export interface Course {
  id: number,
  title: string,
  description: string,
  level: Level
}

export interface DFile {
  contentType: string,
  description: string,
  id: number,
  name: string,
  path: string,
}

export interface AccessToken {
  token: string,
  course: Course,
  activationDate?: Date,
  daysValid?: number,
  expireDate?: Date,
  isEditable?: boolean
}


export interface AccessTokenResponse {
  token: string,
  courseId: number,
  levelId: string,
  isValid: boolean
}

export interface Usage {
  course: Course,
  file: DFile
}
