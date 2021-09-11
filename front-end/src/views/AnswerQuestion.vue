<template>
    <form class="answer-panel" @submit.prevent="submitAnswer" >
        <label for="answerArea"><strong> Answer Question</strong> <small> ({{answerCharacterCount}}/180)</small></label>
        <textarea id="answerArea" rows="4"  v-model="answerContent"/>

        <div class="answer__submit">
            <button> Answer! </button>
        </div>
    </form>
</template>

<script>
export default {
  name: 'AnswerQuestion',
  data(){
      return{
        answerContent: '',
      }
  },
  computed: {
      answerCharacterCount(){
        return this.answerContent.length;
      }
  },
  methods: {
    submitAnswer(){
      if(this.newTwootContent  && this.answerCharacterCount < 180){
        this.$emit('add-twoot',this.answerContent)
        // return to the previous page
      }
    }
  },
}
</script>

<style scoped>
.answer-panel {
  margin-top: 20px;
  padding: 100px 100px 100px 100px;
  display: flex;
  flex-direction: column;
}

textarea {
    border: 1px solid #DFE3E8;
    border-radius: 5px;
}

.answer__submit{
    display: flex;
    justify-content: space-between;
}

button {
    padding: 5px 20px;
    margin: auto 0;
    border-radius: 5px;
    border: none;
    background-color: deeppink;
    color: white;
    font-weight: bold;
}
/*
.create-twoot-panel.--exceeded {
    color: red;
    border-color: red;
}
button {
    background-color: red;
    color: white;
}

:class="{'--exceeded':answerCharacterCount>180}"
*/
</style>
