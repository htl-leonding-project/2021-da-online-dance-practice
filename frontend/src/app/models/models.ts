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
