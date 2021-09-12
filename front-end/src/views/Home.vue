<template>
  <div class="container">
    <div class="home_item">
      <div class="quetion">
        <h4>what is your name ?</h4>
      </div>
      <div class="name">
          <div class="name_photo">
            <b-avatar src="https://placekitten.com/300/300"></b-avatar>
          </div>
          <div class="name_time">
            <h6 class="myname">
               <span> Nour ahmed</span>
            </h6>
            <div class="time">
                <span>10 days ago</span>
            </div>
          </div>
      </div>
      <div class="answer">
        <span>my name is omahhhhhhhhhhhhh hhhhhhhhhhhhhhh gggggggggggggggggg fffffffffffffff ddddddddddddddd ggggggggggggggggg ttttttttttttttttttt sssssssssssssssss r</span>
      </div>
      <div class="like">
             <button class="btn btn-default" @click="toggleLike" ><span class="grey" v-if="liked==false"><font-awesome-icon icon="home" /></span>
             <span class="red" v-if="liked==true"><font-awesome-icon icon="home" /></span> {{ likesCount }}</button>
      </div>
    </div>
     <div class="home_item">
      <div class="quetion">
        <h4>what is your name ?</h4>
      </div>
      <div class="name">
          <div class="name_photo">
            <b-avatar src="https://placekitten.com/300/300"></b-avatar>
          </div>
          <div class="name_time">
            <h6 class="myname">
               <span> Nour ahmed</span>
            </h6>
            <div class="time">
                <span>10 days ago</span>
            </div>
          </div>
      </div>
      <div class="answer">
        <span>my name is omahhhhhhhhhhhhh hhhhhhhhhhhhhhh gggggggggggggggggg fffffffffffffff ddddddddddddddd ggggggggggggggggg ttttttttttttttttttt sssssssssssssssss r</span>
      </div>
      <div class="like">
             <button class="btn btn-default" @click="toggleLike" ><span :class="[liked==true ? 'red' : 'grey']"><font-awesome-icon icon="home" /></span>
{{ likesCount }}</button>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'Home',
  data(){
    return{
     liked: false,
     likesCount: 12
    }
  },
  components: {
    
  },
  methods: {
        toggleLike: function() { 
            this.liked = ! this.liked;

            this.liked ? this.likesCount++ : this.likesCount--;
        }
    }
}
</script>
<style scoped>
.home_item
{
  background-color: #FFF;
  padding: 20px;
  border-radius: 10px;
  margin: 20px;
}
.container 
{width: 60%;}
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
