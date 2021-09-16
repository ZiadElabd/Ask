<template>

 <div class="profile">
  <Navbar />

     <div class="background">
         <div class="overlay">

         </div>
         <div class="cover">
             <img src="../zz.jpg" alt="">

         </div>
     </div>
    <div class="container">
       <div class="profile-content">
                <div class="profile_photo">
                    <div class="name">
                          <div class="name_photo">
                              <b-avatar src="https://placekitten.com/300/300"></b-avatar>
                          </div>
                          <div class="name_time">
                              <div class="time">
                                  <span>@omarrehan0020</span>
                              </div>
                              <h6 class="myname">
                              <span> Omar Rehan</span>
                              </h6>
                          </div>
                        </div>
                
     
      </div>
          <div class="send_question">
              <div class="ask_yourself">
                  <span>Ask yourself</span>
              </div>
              <div class="question_form">  
                    <textarea class="form-control" aria-label="With textarea" placeholder="What,When,Why..Ask" rows="1" ></textarea>
                </div>
              <div class="question-buttons">
                  <div class="content">
                        <label class="switch">
                            <input type="checkbox" v-model="checked" id="any" > 
                            <span class="slider round"></span>
                        </label>
                        <label for="any">Ask anonymously {{checked}}</label>
                    </div>
                    <span class="send">Send</span>
              </div>
              </div>  
     <div v-for="msg in messages" class="home_item" :key="msg.id">
      <div class="quetion">
       
      </div>
       <div class="send" >
          <div class="anymo" v-if="msg.anymonous==false">
            <span>
            <b-avatar :src="msg.photo" size="1.5rem"></b-avatar>
          </span>
          <span class="sender"> {{msg.sender}}</span>
          </div>
        <h4>{{msg.question}}</h4>
        <div class="time">
            <span>{{msg.time}}</span>
        </div>
      
      <div class="answer">
        <span>{{msg.answer}}</span>
      </div>
      <div class="like">
             <button class="btn btn-default" @click="toggleLike(msg)" ><span :class="[msg.liked==true ? 'red' : 'grey']"><font-awesome-icon icon="home" /></span>
{{ msg.number_of_likes }}</button>
      </div>
    </div>
  </div>
      
     </div>
    </div>
 </div>
</template>

<script>
import Navbar from '../components/nbar.vue';

export default {
  name: 'profile',
  data(){
    return{
     liked: false,
     likesCount: 12,
     checked : true ,
     messages: [
       {
         question : "What is your name",
         sender : "Ali Ibrahem",
         reciever : "Ali Ibrahem",
         photo : "https://placekitten.com/300/300",
         time : "10 days ago",
         answer : "My name is omar",
         liked : true ,
         number_of_likes : 12 ,
         anymonous : false ,
       },
       {
         question : "What is your name",
         sender : "Ali Ibrahem",
         reciever : "Ali Ibrahem",
         photo : "https://placekitten.com/300/300",
         time : "10 days ago",
         answer : "My name is omar",
         liked : true ,
         number_of_likes : 12 ,
         anymonous : true ,
       },
        {
         question : "What is your name",
         sender : "Ali Ibrahem",
         reciever : "Ali Ibrahem",
         photo : "https://placekitten.com/300/300",
         time : "10 days ago",
         answer : "My name is omar",
         liked : true ,
         number_of_likes : 12 ,
         anymonous : true ,
       },
        {
         question : "What is your name",
         sender : "Ali Ibrahem",
         reciever : "Ali Ibrahem",
         photo : "https://placekitten.com/300/300",
         time : "10 days ago",
         answer : "My name is omar",
         liked : true ,
         number_of_likes : 12 ,
         anymonous : true ,
       },
        {
         question : "What is your name",
         sender : "Ali Ibrahem",
         reciever : "Ali Ibrahem",
         photo : "https://placekitten.com/300/300",
         time : "10 days ago",
         answer : "My name is omar",
         liked : true ,
         number_of_likes : 12 ,
         anymonous : true ,
       },
       {
         question : "What is your name",
         sender : "Ali Ibrahem",
         reciever : "Ali Ibrahem",
         photo : "https://placekitten.com/300/300",
         time : "10 days ago",
         answer : "My name is omar",
         liked : false ,
         number_of_likes : 11 ,
         anymonous : true ,
       }

     ]
    }
  },
  components: {
    Navbar
  },
  methods: {
     
        toggleLike: function(msg) { 
            msg.liked = ! msg.liked;

            msg.liked ? msg.number_of_likes++ : msg.number_of_likes--;
        }
    }
}
</script>
<style scoped>
.profile .cover
{
    width: 100%;
    height: 55%;
    position: fixed;
    top: 60px;
     box-shadow: 100px 100px blur spread #000 inset;
}
.cover img
{
    width: 100%;
    height: 100%;
   
}
.profile
{
    background-color: #131619;
    height:100000px ;
}

.overlay
{
    width: 100%;
    background-color: rgba(0, 0, 0, .5);
    position: fixed;
    top: 60px;
    right: 0;
    left: 0;
    height: 55vh;
    z-index: 10;
    box-shadow: inset 0 -40px 50px 10px #131619;
}

.profile-content
{
    position: relative;
    z-index: 11166;
}
.background
{
    background-color: rgba(0, 0, 0, .5);
    z-index: 10;
}
.home_item
{
  background-color: #FFF;
  padding: 20px;
  border-radius: 10px;
  margin: 20px;
}
.container 
{width: 60%;}
.sender 
{
  font-size: 13px;
}
.name
{
  display: flex;
}
.name .name_photo , .name .answer
{
  margin: 5px;
}
.name .myname
{
  margin-top: 6px;
  font-size: 90%;
}
.name_time{
  padding-left: 4px;
}
.name .time
{
  font-size: 70%;
  margin-top: -7px;
  color: #B9B9BB;
}
.home_item .time
{
  margin-top: -10px;
  font-size: 12px;
  color: #8f8f96;
  margin-bottom: 10px;
}
.like
{
  margin-left: -10px;
  margin-top: 5px;
  font-size: 150%;
}
.btn span.grey 
{
  color: #CDCDD9;
}
.btn span.red 
{
  color: #EE4C22;
}
.like .btn
{
  border: 0;
  font-size: 20px;
}
.profile_photo
{
    padding: 40px 20px 50px;
}
.profile_photo .b-avatar 
{
    width: 6rem;
    height: 6rem;
    border: solid 4px rgba(117, 116, 116,.35);
}
.profile_photo .name_time
{
    padding: 30px 20px;
    color: #FFF;
    font-size: 120%;
}
.profile_photo .name .name_photo
{
  cursor: pointer;
}
.profile_photo .time
{
    color: #FFF;
}
.send_question
{
    background-color: #000;
    padding: 20px;
    margin: 20px;
    border-radius: 10px;
}
.question_form .form-control
{
    border-radius: 7px;
    min-height: 20px;
    margin: 15px 0 ;
    padding: 10px ;
}



.switch {
  position: relative;
  display: inline-block;
  width: 50px;
  height: 25px;
    margin-right: 10px;
}

.switch input {
  opacity: 0;
  width: 0;
  height: 0;
}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #6E6E6E;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 18px;
  width: 18px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  transition: .4s;
}

input:checked + .slider {
  background-color: #E01144;
}



input:checked + .slider:before {
  transform: translateX(23px);
}

.slider.round {
  border-radius: 25px;
}

.slider.round:before {
  border-radius: 50%;
}
.question-buttons .content label
{
       font-weight: 200;
}
.question-buttons .content label 
{
    font-size: 80%;
    color: #8f8f96;
}
.question-buttons .content label:hover 
{
    color: #FFF;
    transition: .5s;
}

 
.question-buttons .content label
{
    cursor: pointer;
}
.send_question .ask_yourself span
{
    color: #FFF;
}
.question-buttons
{
  position: relative;
  padding-top: 10px;
}
.question-buttons .send
{
  position: absolute;
  right: 0;
  bottom: 0;
  color: #FFF;
  background-color: #E01144;
  padding: 7px 30px;
  cursor: pointer;
  border-radius: 4px;
}

</style>
