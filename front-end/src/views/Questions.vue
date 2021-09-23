<template>
<div>
  <Navbar />
  <div class="container">
    <div class= "Questions-wrapper">
      <QuestionItem 
        v-for ="question in questions" 
        :key="question.StringID"
        :userName="user.userName"
        :question = "question"  
        @answer="answer(question.stringID)"
      />
    </div>
  </div>
  </div>
</template>

<script>

import QuestionItem from "../components/QuestionItem.vue";
import Navbar from '../components/nbar.vue'; 

export default {
  name: 'Questions',
  components: {
    QuestionItem,
    Navbar
  },
  data() {
    return {
      user: {
        id: 1,
        userName: 'ziadElabd',
        firstName: 'ziad',
        secondName: 'elabd',
        email: 'ziad.elabd91@gmail.com',
      }
    }
  },
  methods: {
    answer(id){
      console.log("answer");
      console.log(id);
      this.$router.push({ name: "AnswerQuestion" , params: { questionID: id } });
    }
  },
  computed:{
    questions(){
      return this.$store.state.questions;
    }
  },
  created(){
    console.log('userID in questions page' + this.$store.state.userID);
    this.$store.dispatch('getQuestions');
  }
}
</script>

<style  scoped>
.container {
  width: 60%;
}
/*
.Questions-wrapper{
  display: grid;
  grid-gap: 10px;
  height: auto;
  width: 500px;
  padding: 50px 50px 50px 50px;
}
*/
</style>
