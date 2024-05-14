// rfce
import { withTranslation } from 'react-i18next'
import { Link } from 'react-router-dom/dist'

// FUNCTION COMPONENT MAIN
function MainComponent() {
  return (
    <>
    <br /><br /><br /><br />
    Lorem ipsum dolor, sit amet consectetur adipisicing elit. Autem placeat cupiditate assumenda maiores? Veritatis numquam animi recusandae praesentium dignissimos voluptatum fuga ea, cumque ratione deserunt, mollitia delectus et rerum officia.
    Deserunt ullam iusto inventore fugiat sunt itaque dicta doloribus, amet nobis illum non, nostrum et, nihil quas sit consequatur consectetur commodi id ad eum? Quia laudantium libero iste ipsam molestiae.
    Odit non dicta cupiditate aliquid quasi quisquam eius fuga deserunt illum maiores omnis, blanditiis, praesentium voluptatem vero error, saepe fugit officiis iste quibusdam provident magni reiciendis! Vero incidunt inventore cum.
    Sint corporis magnam iure nemo, quas aut debitis facilis perspiciatis nobis ullam voluptate molestiae aspernatur, ducimus libero laboriosam? Nisi deleniti recusandae sed velit ea officia voluptate. Eius totam suscipit voluptas.
    Animi cupiditate maxime ipsam non porro ratione pariatur placeat optio, enim ducimus id nobis. Unde, officia eius esse asperiores ratione veniam assumenda pariatur molestiae est, id omnis dolorem, provident cupiditate.
  
  <br/>
  <Link to="/blog/category/list" className="btn btn-primary">Blog Category</Link>
   </>
  )
}

// Export
export default withTranslation()(MainComponent)