import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
//import { ProjectUrlComponent } from './project-url/project-url.component';
import { FormsModule } from '@angular/forms';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { UserComponent } from './user/user.component';
import { HttpClientModule } from '@angular/common/http';
import { CustomerComponent } from './customer/customer.component';
import { ViewAdminComponent } from './view-admin/view-admin.component';
import { UpdateAdminComponent } from './update-admin/update-admin.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { HomeComponent } from './home/home.component';
import { ViweCustomerByCityComponent } from './viwe-customer-by-city/viwe-customer-by-city.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { AboutComponent } from './about/about.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AddvegetableComponent } from './addvegetable/addvegetable.component';
import { UpdateVegetableComponent } from './update-vegetable/update-vegetable.component';
import { ViewVegetableComponent } from './view-vegetable/view-vegetable.component';
import { ViewvegetableByCategoryComponent } from './viewvegetable-by-category/viewvegetable-by-category.component';
import { OrderComponent } from './order/order.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
import { ViewOrderComponent } from './view-order/view-order.component';
import { VieworderlistComponent } from './vieworderlist/vieworderlist.component';
import { ViewOrderByIdComponent } from './view-order-by-id/view-order-by-id.component';
import { ViewOrderByDateComponent } from './view-order-by-date/view-order-by-date.component';
import { CartComponent } from './cart/cart.component';
import { IncreaseVegQuantityComponent } from './increase-veg-quantity/increase-veg-quantity.component';
import { DecreaseVegQuantityComponent } from './decrease-veg-quantity/decrease-veg-quantity.component';
import { AddbillComponent } from './addbill/addbill.component';
import { UpdateBillingDetailsComponent } from './update-billing-details/update-billing-details.component';
//import { HttpClient } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    WelcomeComponent,
    ErrorComponent,
    UserComponent,
    CustomerComponent,
    ViewAdminComponent,
    UpdateAdminComponent,
    ViewCustomerComponent,
    UpdateCustomerComponent,
    HomeComponent,
    ViweCustomerByCityComponent,
    FeedbackComponent,
    AboutComponent,
    ContactUsComponent,
    AddvegetableComponent,
    UpdateVegetableComponent,
    ViewVegetableComponent,
    ViewvegetableByCategoryComponent,
    OrderComponent,
    UpdateOrderComponent,
    ViewOrderComponent,
    VieworderlistComponent,
    ViewOrderByIdComponent,
    ViewOrderByDateComponent,
    CartComponent,
    IncreaseVegQuantityComponent,
    DecreaseVegQuantityComponent,
    AddbillComponent,
    UpdateBillingDetailsComponent,
    //ProjectUrlComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
  HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
