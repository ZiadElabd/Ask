<template>
  
    <div class= "question-item" >
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

    <div class="question"  @click="answerQuestion(question.id)" >
      <h4>{{question.questionText}}</h4>
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
    },
    async getQuestions(){
        try {
          const response = await fetch( "http://localhost:5050/signin/" , {
              method: "post" , 
              headers: { "Content-Type": "application/json" },
              body: JSON.stringify(this.form)
          }).then(this.checkState)
          .then(this.parseJSON)
          console.log('ziad');
          console.log(response);
      } catch (error) {
          alert('error');
      } 
    },
  }
}
</script>
<style scoped>
.question-item{
  background-color: #FFF;
  padding: 20px;
  border-radius: 10px;
  margin: 20px;
}
.question{
  cursor: pointer;
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
</style>