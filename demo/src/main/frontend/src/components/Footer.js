import InstagramIcon from '@material-ui/icons/Instagram';
import TwitterIcon from '@material-ui/icons/Twitter';
import FacebookIcon from '@material-ui/icons/Facebook';

function Footer() {
    
    return(
        <div className="footer">
                <p className='found'>Found us here</p>
            <div className='Icons'>
            <TwitterIcon className='icon'/>
            <InstagramIcon className="icon"/>
            <FacebookIcon className='icon'/>
            </div>

        </div>
    )
}
export default Footer;