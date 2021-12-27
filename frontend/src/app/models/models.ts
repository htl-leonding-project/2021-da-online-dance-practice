export interface User {
  firstname: string
  id: number
  lastname: string
  password: string
  role: Role
  username: string
}

export enum Role {
  STUDENT = 'STUDENT',
  TEACHER = 'TEACHER'
}
