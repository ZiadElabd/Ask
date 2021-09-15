<template>
  <div class="container">
    <div class= "Questions-wrapper">
      <QuestionItem 
        v-for ="question in questions" 
        :key="question.id" 
        :userName="user.userName"
        :question = "question"  
        @answer="answer(question.id)"
      />
    </div>
  </div>
</template>

<script>

import QuestionItem from "../components/QuestionItem.vue";

export default {
  name: 'Questions',
  components: {
    QuestionItem
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
      console.log(id);
      this.$router.push({ name: "AnswerQuestion" , params: { questionID: id } });
    }
  },
  computed:{
    questions(){
      return this.$store.state.questions;
    }
  },
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
