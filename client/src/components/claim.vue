<template>
  <v-app id="inspire" :style="{ backgroundImage: 'url(' + require('@/assets/a.jpeg') + ')' }">
    <v-navigation-drawer
      v-model="drawer"
      app
    >
      <v-list dense>
        <v-list-item @click="null">
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item @click="null">
          <v-list-item-action>
            <v-icon>mdi-contact-mail</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Contact</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      color="yellow accent-4"
      dark
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>แบบเรียกร้องค่าสินไหมทดแทนค่ารักษาพยาบาล</v-toolbar-title>
    </v-app-bar>

    <div class="bgn">
    <v-container nowrap  class="justify-center">
      <v-form v-model="valid" ref="form">
      <v-layout  row nowrap class="justify-center">
        <v-flex md12 xs12 lg12 xl3>
              <v-col>
              <h3 class="text-center">
                      รายละเอียดการรักษาพยาบาล
              </h3>
              </v-col>
        </v-flex>  
            <div class="justify-center">
              <v-flex md12 xs12 lg12 xl3>
                  <v-text-field
                      class="justify-center"
                      label="ค้นหาIDลูกค้า"
                      style="width:300px"
                      v-model="claim.customerId"
                  ></v-text-field>
              </v-flex>
            </div>

             <v-flex md12 xs12 lg12 xl3>
              <p  class="text-center" lg12 xs3 v-if="customerCheck != ''">Customer Name : {{customerName}}</p>
              </v-flex>
            
             <div class="btncenter">
              <v-flex md12 xs12 lg12 xl3>
                  <v-btn class="justify-center" @click="findCustomer" depressed large color="primary">ค้นหา</v-btn>
              </v-flex>

              <div v-if="customerCheck">
               <v-flex md6 xs12 lg12 xl3>
                  <v-select
                    style="width: 300px"
                    label="ให้สั่งจ่ายเช็คในนามของ"
                    v-model="claim.paychecksId"
                    :items="paychecks"
                    item-text="payto"
                    item-value="id"
                    :rules="[(v) => !!v || 'Item is required']"
                  ></v-select>
               </v-flex>
       
               <v-flex md6 xs12 lg12 xl3>
                 <v-select
                  label="ได้รับการตรวจโดยวิธี"
                  style="width: 300px"
                  v-model="claim.treatmethodId"
                  :items="treatmethod"
                  item-text="treatby"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
               </v-flex>
          
                <v-flex md6 xs12 lg12 xl3>
                 <v-select
                  label="วิธีการรับการรักษา"
                  style="width: 300px"
                  v-model="claim.curebyId"
                  :items="cureby"
                  item-text="curemeth"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
                </v-flex>

                <v-flex md6 xs12 lg12 xl3>
                  <v-select
                  style="width: 300px"
                  label="แพ็คเก็จที่สมัครกับเรา"
                  v-model="claim.insuranceId"
                  :items="insurance"
                  item-text="instype"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
                </v-flex>
                <v-flex md6 xs12 lg12 xl3 >
                  <v-select
                  label="โรงพยาบาลที่เข้ารับการรักษา"
                  style="width: 300px"
                  v-model="claim.hospitalId"
                  :items="hospital"
                  item-text="hos_name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
                </v-flex>
                <div class="btncenter">
            <v-col cols="12">
              <v-btn large class="justify-center" md4 style="hight:300" depressed @click="saveclaim" :class="{ red: !valid, green: valid }">ส่งแบบฟอร์ม</v-btn>  
            </v-col>
            </div>
                </div>
             </div>
      </v-layout>
     </v-form>
           
           
    </v-container>
    </div> 
  </v-app>
</template>

<script>
import http from "../http-common";
  export default {
    props: {
      source: String,
    },
    name: "claim",
   data() {
    return {
      claim: {
        paychecksId: "",
        treatmethodId: "",
        hospitalId: "",
        insuranceId:"",
        curebyId: "",
        customerId: ""
      },
      valid: false,
      customerCheck: false,
      customerName: "",
      drawer: false
    };
  },
  methods:{
   /* eslint-disable */
      getPaycheckss(){
        http
        .get("/paychecks")
        .then(response =>{
          this.paychecks = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        });
      },
      getTreatmethods(){
        http
        .get("/treatmethod")
        .then(response =>{
          this.treatmethod = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },
      getHospitals(){
        http
        .get("/hospital")
        .then(response =>{
          this.hospital = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },
      getInsurances(){
        http
        .get("/Insurance")
        .then(response =>{
          this.insurance = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },
      getCurebies(){
      http
      .get("/cureby")
      .then(response =>{
        this.cureby = response.data;
        console.log(response.data);
      })
      .catch(e =>{
        console.log(e);
      })
    },
    getCustomers(){
      http
      .get("/customer")
      .then(response =>{
        this.customer = response.data;
        console.log(response.data);
      })
      .catch(e =>{
        console.log(e);
      })
    },
      findCustomer() {
          http
            .get("/customer/" + this.claim.customerId)
            .then(response => {
              console.log(response);
              if (response.data != null) {
                this.customerName = response.data.name;
                this.customerCheck = response.status;
              } else {
                this.clear()
              }          
            })
            .catch(e => {
              console.log(e);
            });
          this.submitted = true;
        },
        clear() {
      this.$refs.form.reset();
      this.customerCheck = false;
    },
    saveClaim() {
      http
        .post(
          "/Claim/" +
            this.claim.customerId +
            "/" +
            this.claim.paychecksId +
            "/" +
            this.claim.treatmethodId +
            "/" +
            this.claim.hospitalId +
            "/" +
            this.claim.insuranceId +
            "/" +
            this.claim.curebyId,
          this.claim
        )
        .then(response => {
          console.log(response);
          this.$router.push("/view");
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },
    refreshList() {
      this.getPaycheckss();
      this.getTreatmethods();
      this.getHospitals();
      this.getInsurances();
      this.getCurebies();
      this.getCustomers();
    }
  },
      mounted() {
      this.getPaycheckss();
      this.getTreatmethods();
      this.getHospitals();
      this.getInsurances();
      this.getCurebies();
      this.getCustomers();
      }
  
};
</script>

<style>
.btncenter{
    
    display: block;
    margin-left: auto;
    margin-right: auto;
}
.bgn{
    display: block;
    margin-left: auto;
    margin-right: auto;
    height: 1080px;
    width: 1000px; 
    background-color: #c88d8b;
    opacity: 0.9;
    -moz-box-shadow:inset 0 0 10px #000000;
   -webkit-box-shadow:inset 0 0 10px #000000;
   box-shadow:inset 0 0 10px #000000;
}

</style>