<template>
  <div class= "question-item"  @click="answerQuestion(question.id)">
    <div class= "user-profile__twoot">
        <div class= "twoot-item__user">
            @{{userName}}
        </div>
        <div class= "twoot-item__content">
            {{question.conntent}}
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'QuestionItem',
  props: {
      userName: {
        type: String,
        required: true
      },
      question: {
          type: Object,
          required: true
      }
  },
  methods: {
    answerQuestion(id){
      this.$emit('answer' , id);
    }
  }
}
</script>
<style scoped>
.question-item{
    padding: 20px;
    background-color: rgb(155, 111, 111);
    border-radius: 5px;
    border: 1px solid #DFE3E8;
    box-sizing: border-box;
    cursor: pointer;
    transition: all 0.25s ease;
}
.question-item:hover {
    transform: scale(1.05,1.05);
}
.twoot-item__user {
    font-weight: bold;
}
</style>