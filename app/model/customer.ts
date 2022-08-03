import { Address } from "./address";
import { User } from "./user";

export class Customer {
    public customerId:number;
    public name:string;
    public mobileNumber:string;
    public emailId:string;
    public password:string;
    public confirmPassword:string;
    public address:Address=new Address();
    public user:User=new User();

}
