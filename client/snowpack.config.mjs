import proxy from 'http2-proxy';

/** @type {import("snowpack").SnowpackUserConfig } */

export default {
  mount: {
    public: '/',
    src: '/_dist_',
  },
  plugins: [
    '@snowpack/plugin-react-refresh',
    '@snowpack/plugin-dotenv',
    '@snowpack/plugin-typescript',
  ],
  devOptions: {
    port: 3000,
  },
  routes: [
    {
      src: '/mancala/.*',
      dest: (req, res) => {
        // remove /api prefix (optional)

        return proxy.web(req, res, {
          hostname: 'backend',
          port: 8080,
        });
      },
    },
  ],
};
