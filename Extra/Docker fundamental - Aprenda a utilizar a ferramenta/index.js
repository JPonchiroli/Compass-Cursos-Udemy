const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.send("Hello Docker! Update!")
})

app.listen(port, () => {
  console.log(`Application running in port ${port}`)
})