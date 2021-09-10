<template>
  <div class="questions">
    <div class= "Questions-wrapper">
      <QuestionItem 
        v-for ="question in user.questions" 
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
        questions: [
          { id: 1 , conntent: "ziad is my Name" },
          { id: 2 , conntent: "osama is my brother" }
        ]
      }
    }
  },
  methods: {
    answer(id){
      console.log(`Favourite tweet #${id}`);
    }
  },
}
</script>

<style  scoped>

.Questions-wrapper{
  display: grid;
  grid-gap: 10px;
  padding: 50px 50px 50px 50px;
}

</style>
