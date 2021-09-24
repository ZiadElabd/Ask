<template>
  <div class="notifications">
    <Navbar />
    <div class="users container">
            <div class="not">
                <div>
                  <b-avatar src="" size="3rem"></b-avatar>
                </div>
                <div class="que">
                  <span>omar rehan</span> answered your question <span>what is youufjdgyyyyfyfyfy fygtfyuikfo fuyhfur name ?</span><br>
                  <p>10 days ago</p>
                </div>
            </div>
             <div class="not">
                <div>
                  <b-avatar src="" size="3rem"></b-avatar>
                </div>
                <div class="que">
                  <span>omar rehan</span> answered your question <span>what is youufjdgyyyyfyfyfy fygtfyuikfo fuyhfur name ?</span><br>
                  <p>10 days ago</p>
                </div>
            </div>
             <div class="not">
                <div>
                  <b-avatar src="" size="3rem"></b-avatar>
                </div>
                <div class="que">
                  <span>omar rehan</span> answered your question <span>what is youufjdgyyyyfyfyfy fygtfyuikfo fuyhfur name ?</span><br>
                  <p>10 days ago</p>
                </div>
            </div>
    </div>
  </div>
</template>

<script>
import Navbar from '../components/nbar.vue';

export default {
  name: 'Notifications',
  components: {
    Navbar
  }
}
</script>
<style scoped>
.notifications
{
  background-color: #131619;
}
.users
{
  width: 100%;
  height: 1000px;
  background-color: #FFF;
  border-radius: 10px ;
  padding: 20px;
}
.not
{
  display: flex;
  padding: 20px 0 ;
  border-bottom: 1px solid #DDD;
  
}
.not .que
{
  margin-top: 10px;
}
.que span
{
  font-weight: 700;
}
.que p
{
  font-size: 10px;
  color: #bdb6b6;
  margin-top: 9px;
}
.que span:first-of-type
{
  font-weight: 700;
  color: #EE1144;
}
.container
{
  width: 40%;
}

.user-content
{
  display: flex;
  justify-content: space-between;
  padding: 10px 0 ;
  border-bottom: 1px solid #DDD;
}
.user-img
{
  cursor: pointer;
}

</style>
