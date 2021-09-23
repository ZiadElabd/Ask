<template>
 <div class="questions">
    <div class="container" >
    <div class= "question-answer">
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

      <div class="quetion">
        <h4>{{question.questionText}}  id = {{questionID.valueOf()}}</h4>
      </div>

      <form  @submit.prevent="submitAnswer" >
          <b-form-textarea
            id="textarea"
            v-model="answerContent"
            placeholder="Write your answer"
            rows="4"
            max-rows="4"
          >
          </b-form-textarea>

          <div class="answer__submit">
              <button > Answer! </button>
          </div>
      </form>
      
    </div>
  </div>
 </div>
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
      },
      questionID(){
        console.log('ziad');
        console.log(this.$route.params.questionID);
        return this.$route.params.questionID;
      },
      questions(){
        return this.$store.state.questions;
      },
      question(){
        return this.questions.find(x => x.id == this.questionID);
        /*for(var i=0; i<this.questions.length; i++) {
          if(this.questions[i].id == this.questionID) {
            return this.questions[i];
          }
        }
        return null;*/
      },
      userID(){
        return this.$store.state.userID;
      }
  },
  methods: {
    submitAnswer(){
      //this.$emit('answer',this.answerContent)
      // return to the previous page
      fetch("http://localhost:5050/answerquestion/" + this.userID , {
          method: "post",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            id : this.questionID,
            answer: this.answerContent
          }),
      })/*.then((response) => {
          return response.text();
      }).then((data) => {
          console.log("signup =  " +  data);
      });*/
    }
  },
}
</script>

<style scoped>

.container {
  width: 60%;
}

.quetion{
  margin-bottom: 30px;
}
.question-answer{
  background-color: #FFF;
  padding: 20px;
  border-radius: 10px;
  margin: 20px;
}



.answer__submit{
    display: flex;
    flex-direction:row-reverse;
    /*justify-content: space-between;*/
}

button {
    padding: 5px 20px;
    margin: auto 0;
    border-radius: 5px;
    border: none;
    background-color: deeppink;
    color: white;
    font-weight: bold;
    margin-top: 20px;
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
