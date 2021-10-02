<template>
  <div class="questions">
    <Navbar />
    <div class="container">
      <div class="question-answer">
        <div class="name">
          <div class="name_photo">
            <b-avatar :src="decodeImage(question.askedPhoto)"></b-avatar>
          </div>
          <div class="name_time">
            <h6 class="myname">
              <span> {{ question.askedUser }} </span>
            </h6>
            <div class="time">
              <span>{{ question.time }}</span>
            </div>
          </div>
        </div>

        <div class="quetion">
          <h4>{{ question.questionText }}</h4>
        </div>

        <form @submit.prevent="submitAnswer">
          <b-form-textarea
            id="textarea"
            v-model="answerContent"
            placeholder="Write your answer"
            rows="4"
            max-rows="4"
          >
          </b-form-textarea>

          <div class="answer__submit">
            <button>Answer!</button>
          </div>
        </form>
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
      answerContent: "",
    };
  },
  computed: {
    questionID() {
      console.log("ziad");
      console.log(this.$route.params.questionID);
      return this.$route.params.questionID;
    },
    questions() {
      return this.$store.state.questions;
    },
    question() {
      return this.questions.find((x) => x.stringID == this.questionID);
    },
    userID() {
      return this.$store.state.userID;
    },
  },
  methods: {
    async submitAnswer() {
      await fetch("http://localhost:5050/answerQuestion/" + this.userID, {
        method: "post",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          QuestionStringID: this.questionID,
          text: this.answerContent,
          userName: this.$store.state.userName,
        }),
      });
      this.$store.commit('delete');
      this.$router.push({ name: "Questions" });
    },
    decodeImage(image){
      return 'data:image/jpeg;base64,' + image;
    },
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
