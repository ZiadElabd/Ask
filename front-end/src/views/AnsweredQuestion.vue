<template>
  <div class="questions">
    <Navbar />
    <div class="container">
      <div class="question-answer">
        <div class="name">
          <div class="name_photo" v-if=" ! question.anoymos">
            <b-avatar :src="decodeImage(question.askedPhoto)" ></b-avatar>
          </div>
          <div class="name_time">
            <h6 class="myname" v-if=" ! question.anoymos">
              <span> {{ question.askedUser }}</span>
            </h6>
            <div class="time">
              <span>{{ question.time }}</span>
            </div>
          </div>
        </div>

        <div class="quetion">
          <h4>{{ question.questionText }}</h4>
        </div>

        <div class="name" >
          <div class="name_photo">
            <b-avatar :src="decodeImage(question.replies.answeredPhoto)" ></b-avatar>
          </div>
          <div class="name_time">
            <h6 class="myname">
              <span>{{ question.replies.userNameAnswered }}</span>
            </h6>
            <div class="time">
              <span> {{ question.replies.time }} </span> 
            </div>
          </div>
        </div>
        <div class="answer">
          <span>{{ question.replies.replyText }}</span> 
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "../components/nbar.vue";

export default {
  components: {
    Navbar,
  },
  name: "AnswerQuestion",
  data() {
    return {
      questionResponse:{},
    };
  },
  computed: {
    questionID(){
      return this.$route.params.questionID;
    },
    userID() {
      return this.$store.state.userID;
    },
    question(){
      return this.$store.state.cur_question;
    }
  },
  methods: {
    decodeImage(image){
      return 'data:image/jpeg;base64,' + image;
    },
  },
  created() {
    this.$store.dispatch("getAQuestion", this.questionID);
  },
};
</script>

<style scoped>
.container {
  width: 60%;
}

.quetion {
  margin-bottom: 30px;
}
.question-answer {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  margin: 20px;
}

.answer__submit {
  display: flex;
  flex-direction: row-reverse;
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
.name {
  display: flex;
}
.name .name_photo,
.name .answer {
  margin: 5px;
}
.name .myname {
  margin-top: 6px;
  font-size: 90%;
}
.name_time {
  padding-left: 4px;
}
.name .time {
  font-size: 70%;
  margin-top: -7px;
  color: #b9b9bb;
}
</style>
