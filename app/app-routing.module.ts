import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AddvegetableComponent } from './addvegetable/addvegetable.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { CustomerComponent } from './customer/customer.component';
import { ErrorComponent } from './error/error.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UpdateAdminComponent } from './update-admin/update-admin.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { UpdateVegetableComponent } from './update-vegetable/update-vegetable.component';
import { UserComponent } from './user/user.component';
import { ViewAdminComponent } from './view-admin/view-admin.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { ViewVegetableComponent } from './view-vegetable/view-vegetable.component';
import { ViewvegetableByCategoryComponent } from './viewvegetable-by-category/viewvegetable-by-category.component';
import { ViweCustomerByCityComponent } from './viwe-customer-by-city/viwe-customer-by-city.component';
import { ViewOrderByIdComponent } from './view-order-by-id/view-order-by-id.component';
import { ViewOrderComponent } from './view-order/view-order.component';
import { OrderComponent } from './order/order.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ViewOrderByDateComponent } from './view-order-by-date/view-order-by-date.component';
import { VieworderlistComponent } from './vieworderlist/vieworderlist.component';
import { CartComponent } from './cart/cart.component';
import { IncreaseVegQuantityComponent } from './increase-veg-quantity/increase-veg-quantity.component';
import { DecreaseVegQuantityComponent } from './decrease-veg-quantity/decrease-veg-quantity.component';
import { AddbillComponent } from './addbill/addbill.component';
import { UpdateBillingDetailsComponent } from './update-billing-details/update-billing-details.component';

const routes: Routes = [{path:"",component:HomeComponent},
{path:"login",component:LoginComponent},
{path:"login",component:WelcomeComponent},
{path:"welcome/:name",component:WelcomeComponent},
{path:"NewUser",component:UserComponent},
{path:"logout",component:LoginComponent},
{path:"AddUser",component:LoginComponent},
{path:"ViewAdmin",component:ViewAdminComponent},
{path:"CreateCustomer",component:CustomerComponent},
{path:"AddCustomer",component:ViewCustomerComponent},
{path:"UpdateAdminComponent/:adId",component:UpdateAdminComponent},
{path:"updateAdmin",component:ViewAdminComponent},
{path:"ViewCustomer",component:ViweCustomerByCityComponent},
{path:"UpdateCustomer",component:UpdateCustomerComponent},
{path:"ViewCustomers",component:ViewCustomerComponent},
{path:"UpdateCustomerComponent/:customer",component:UpdateCustomerComponent},
{path:"updateCustomer",component:ViewCustomerComponent},
{path:"home",component:HomeComponent},
{path:"about",component:AboutComponent},
{path:"contactUs",component:ContactUsComponent},
{path:"feedback",component:FeedbackComponent},
{path:"CreateVegetable",component:AddvegetableComponent},
{path:"Add Vegetable",component:ViewVegetableComponent},
{path:"ViewVegetable",component:ViewVegetableComponent},
{path:"viewVegetableByCategory",component:ViewvegetableByCategoryComponent},
{path:"UpdateVegetable",component:UpdateVegetableComponent},
{path:"addOrder",component:OrderComponent},
{path:"addOrder",component:VieworderlistComponent},
{path:"orderList",component:VieworderlistComponent},
{path:"viewAllorders",component:ViewOrderComponent},
{path:"viewOrderById",component:ViewOrderByIdComponent},
{path:"viewOrderByDate",component:ViewOrderByDateComponent},
{path:"updateOrder",component:UpdateOrderComponent},
{path:"Cart",component:CartComponent},
//{path:"Add To cart",component:ViewVegetableComponent},
{path:"increaseVegQuantity",component:IncreaseVegQuantityComponent},
{path:"viewAllvegetable",component:ViewVegetableComponent},
{path:"DecreaseVegQuantity",component:DecreaseVegQuantityComponent},
{path:"Order",component:OrderComponent},
{path:"Bill",component:AddbillComponent},
{path:"updateBill",component:UpdateBillingDetailsComponent},
{path:"**",component:ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }