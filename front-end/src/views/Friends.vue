<template>
  <div class="friends">
    <Navbar />
    <div class="users container">
      <input type="search" />
      <div class="user-content">
              <div class="user-img">
                <span>
                  <b-avatar src="" size="3rem"></b-avatar>
                </span>
                <span>Omar Rehan</span>
              </div>
              <div class="follow">
              <b-button variant="outline-danger" v-if="follow == true" @click="toggleFollow">Follow</b-button>
              <b-button variant="danger" v-if="follow==false" @click="toggleFollow" @mouseover="mouseenter" @mouseleave="mouseleave">{{hover}}</b-button>
            </div>
            
      </div>
      <div class="user-content">
              <div class="user-img">
                <span>
                  <b-avatar src="" size="3rem"></b-avatar>
                </span>
                <span>Omar Rehan</span>
              </div>
              <div class="follow">
              <b-button variant="outline-danger" v-if="follow == true" @click="toggleFollow">Follow</b-button>
              <b-button variant="danger" v-if="follow==false" @click="toggleFollow" @mouseover="mouseenter" @mouseleave="mouseleave">{{hover}}</b-button>
            </div>
            
      </div>
      <div class="user-content">
              <div class="user-img">
                <span>
                  <b-avatar src="" size="3rem"></b-avatar>
                </span>
                <span>Omar Rehan</span>
              </div>
              <div class="follow">
              <b-button variant="outline-danger" v-if="follow == true" @click="toggleFollow">Follow</b-button>
              <b-button variant="danger" v-if="follow==false" @click="toggleFollow" @mouseover="mouseenter" @mouseleave="mouseleave">{{hover}}</b-button>
            </div>
            
      </div>
      <div class="user-content">
              <div class="user-img">
                <span>
                  <b-avatar src="" size="3rem"></b-avatar>
                </span>
                <span>Omar Rehan</span>
              </div>
              <div class="follow">
              <b-button variant="outline-danger" v-if="follow == true" @click="toggleFollow">Follow</b-button>
              <b-button variant="danger" v-if="follow==false" @click="toggleFollow" @mouseover="mouseenter" @mouseleave="mouseleave">{{hover}}</b-button>
            </div>
            
      </div>
      <div class="user-content">
              <div class="user-img">
                <span>
                  <b-avatar src="" size="3rem"></b-avatar>
                </span>
                <span>Omar Rehan</span>
              </div>
              <div class="follow">
              <b-button variant="outline-danger" v-if="follow == true" @click="toggleFollow">Follow</b-button>
              <b-button variant="danger" v-if="follow==false" @click="toggleFollow" @mouseover="mouseenter" @mouseleave="mouseleave">{{hover}}</b-button>
            </div>
            
      </div>
      <div class="user-content">
              <div class="user-img">
                <span>
                  <b-avatar src="" size="3rem"></b-avatar>
                </span>
                <span>Omar Rehan</span>
              </div>
              <div class="follow">
              <b-button variant="outline-danger" v-if="follow == true" @click="toggleFollow">Follow</b-button>
              <b-button variant="danger" v-if="follow==false" @click="toggleFollow" @mouseover="mouseenter" @mouseleave="mouseleave">{{hover}}</b-button>
            </div>
            
      </div>
      <div class="user-content">
              <div class="user-img">
                <span>
                  <b-avatar src="" size="3rem"></b-avatar>
                </span>
                <span>Omar Rehan</span>
              </div>
              <div class="follow">
              <b-button variant="outline-danger" v-if="follow == true" @click="toggleFollow">Follow</b-button>
              <b-button variant="danger" v-if="follow==false" @click="toggleFollow" @mouseover="mouseenter" @mouseleave="mouseleave">{{hover}}</b-button>
            </div>
            
      </div>
      <div class="user-content">
              <div class="user-img">
                <span>
                  <b-avatar src="" size="3rem"></b-avatar>
                </span>
                <span>Omar Rehan</span>
              </div>
              <div class="follow">
              <b-button variant="outline-danger" v-if="follow == true" @click="toggleFollow">Follow</b-button>
              <b-button variant="danger" v-if="follow==false" @click="toggleFollow" @mouseover="mouseenter" @mouseleave="mouseleave">{{hover}}</b-button>
            </div>
            
      </div>
      
    </div>
  </div>
</template>

<script>
import Navbar from '../components/nbar.vue';

export default {
  name: 'Friends',
   data(){
     return{
       follow: false ,
       hover: "Following",
     }
   },
   methods: {
        toggleFollow: function() { 
            this.follow = ! this.follow;
        },
        mouseenter: function(){
          this.hover = "Unfollow" ;
        },
        mouseleave: function(){
          this.hover = "Following" ;
        },
    },
  components: {
    Navbar
  }
}
</script>
<style scoped>
.friends
{
  padding-top: 80px;
}
.users
{
  width: 100%;
  height: 1000px;
  background-color: #FFF;
  border-radius: 10px ;
  padding: 20px;
}
.container
{
  width: 40%;
}
.users input
{
  width: 100%;
  height: 50px;
  padding: 10px;
  outline: none;
  border: 1px solid #DDD;
  margin-bottom: 50px;
}
.user-content
{
  display: flex;
  justify-content: space-between;
  padding: 10px 0 ;
  border-bottom: 1px solid #DDD;
}

</style>
