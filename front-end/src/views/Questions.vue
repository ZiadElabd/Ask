<template>
<div>
  <Navbar />
  <div class="container">
    <div class= "Questions-wrapper">
      <QuestionItem 
        v-for ="question in questions" 
        :key="question.StringID"
        :question = "question"  
        @answer="go_to_answerPage(question.stringID)"
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
    }
  },
  methods: {
    go_to_answerPage(id){
      this.$router.push({ name: "AnswerQuestion" , params: { questionID: id } });
    }
  },
  computed:{
    questions(){
      return this.$store.state.questions;
    }
  },
  created(){
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
