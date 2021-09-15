<template>
<div class="container">
  <div class="Settings">
    <form>
      <div class="mb-3">
        <label for="fullname" class="form-label">Full Name</label>
        <input type="text" class="form-control" id="fullname" >
      </div>
      <div class="mb-3">
        <label for="location" class="form-label">Location</label>
        <input type="text" class="form-control" id="location">
      </div>
      <div class="question_form mb-3"> 
            <label for="bio" class="form-label">Bio</label> 
             <textarea class="form-control" aria-label="With textarea" rows="3" id="bio" ></textarea>
         </div>
         <div class="mb-3">
          <label for="username" class="form-label">Username</label>
          <input type="text" class="form-control" id="username" :value="username" disabled>
        </div>
        <div class="mb-3">
            <label for="gender">Birth Date</label> <br>
            <birthdate />
             
        </div>
        <div class="mb-3 paddingwithborder">
            <label for="gender">Gender</label> <br>
            <select>
              <option value="male">Male</option>
              <option value="female">Female</option>
            </select>
        </div>

        <div class="changeprofile paddingwithborder">
          <label >photo</label> <br>
           <b-avatar :src="imageURL"></b-avatar>
          <input type="file" @change="onfileselected" style="display:none"  ref="fileinput" >
          <span @click="$refs.fileinput.click()">Change Photo</span>
        </div>
        <div class="changecover paddingwithborder">
          <label >Background</label> <br>
           <b-avatar :src="imageURL"></b-avatar>
          <input type="file" @change="onfileselected" style="display:none"  ref="fileinput" >
          <span @click="$refs.fileinput.click()">Upload your background</span>
        </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</div>
</template>

<script>

import birthdate from '../components/date.vue'
export default {
  name: 'Settings',
  data(){
    return {
      username: 'omarrehan0020',
      selectedfile:'',
      imageURL:''
    }
  },
  components: {
    birthdate,
  },
  methods: {
   onfileselected: function(event){
     this.getImageBase64(event.target.files[0]) ;

   },
    getImageBase64:function(file){
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = ()=>{
            this.imageURL = reader.result ;
            
        }
        reader.error =()=>{
         alert('Error !!!');
        }
    }
  },
}

</script>
<style scoped>
.Settings
{
  background-color: #FFF;
  width: 100%;
  border-radius: 10px;
  padding: 20px ;
}
.container
{
  width: 40%;
}
select{
  margin: 10px 20px 0 0;
  padding: 3px;
  height: 40px;
}
.paddingwithborder
{
  padding-bottom: 20px;
  border-bottom: 6px solid #DDD;
}
 .changecover
{
  padding: 15px 0 ;
}
.changeprofile span , .changecover span
{
  cursor: pointer;
  color: #EE1144;
  font-size: 18px;
}
.changeprofile .b-avatar, .changecover .b-avatar
{
  width: 4rem;
  height: 4rem;
  margin: 10px 10px 10px 0  ;
}
</style>
