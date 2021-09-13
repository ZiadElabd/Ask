<template>

 <div class="profile">
     <div class="background">
         <div class="overlay">

         </div>
         <div class="cover">
             <img src="../zz.jpg" alt="">

         </div>
     </div>
     <div class="profile-content">
          <div class="container">
   
     <div v-for="msg in messages" class="home_item" :key="msg.id">
      <div class="quetion">
       <div v-if="msg.anymonous==false" class="send">
          <span>
            <b-avatar :src="msg.photo" size="1.5rem"></b-avatar>
          </span>
            <span class="sender"> {{msg.name}}</span>
       </div>
        <h4>{{msg.question}}</h4>
      </div>
      <div class="name">
          <div class="name_photo">
            <b-avatar :src="msg.photo"></b-avatar>
          </div>
          <div class="name_time">
            <h6 class="myname">
               <span> {{msg.name}}</span>
            </h6>
            <div class="time">
                <span>{{msg.time}}</span>
            </div>
          </div>
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
</template>

<script>

export default {
  name: 'profile',
  data(){
    return{
     liked: false,
     likesCount: 12,
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
    height: 60%;
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
    background-color: #000;
    height:100000px ;
}

.overlay
{
    width: 100%;
    height: 40%;
    background-color: rgba(0, 0, 0, .5);
    position: fixed;
    top: 60px;
    right: 0;
    left: 0;
    height: 70vh;
    z-index: 10;
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
</style>
