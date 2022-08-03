import { User } from "./user";

export class Admin {
    public adminId:number;
    public name:string;
    public contactNumber:string;
    public emailId:string;
    public user:User=new User();
}
